import java.io.File




fun imprimiendo(filePath: String): List<String> {

    val readLines = File(filePath).readLines()
    println("num lines: ${readLines.size}")

    return readLines

}


fun getFilesInFolder(folderPath: String) {

    getFilesInFolder(folderPath, "yaml")

}

fun getFilesInFolder(folderPath: String,type: String ) {

    val directory = File(folderPath)

        directory.listFiles()?.filter { it.extension == type }?.forEach {
            cleanKomposeYmlFiles(it.absolutePath)
    }

}


fun cleanKomposeYmlFiles(filePath: String) {
    val joinToString = File(filePath).readLines()
            .map { it.replace("io.kompose.service", "app") }
            .filter { !it.contains("annotations") }
            .filter { !it.contains("kompose") }
            .filter { !it.contains("null") }
            .filter { !it.contains("serviceAccountName") }
            .map {

                var valor = if (it.contains("imagePullPolicy: \"\"")) {
                    it.replace("imagePullPolicy: \"\"", "imagePullPolicy: Never")
                } else {
                    it
                }
                valor
            }
            .joinToString("\n")


    File(filePath).writeText(joinToString)
}