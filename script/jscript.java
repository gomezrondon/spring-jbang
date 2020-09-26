//usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10

public class jscript {

    public static void main(String[] args) {
         UtilKt.getFilesInFolder(args[0]);

        System.out.println("<<Script Executed!!>>");
    }

}

