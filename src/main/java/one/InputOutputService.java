package one;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutputService {
        public static void writeOutPutStreamArr(OutputStream outputStream, int[] arr) throws IOException {
            if (outputStream == null || arr == null) {
                throw new IllegalArgumentException("outputStream==null || arr==null");
            }
            try (DataOutputStream out = new DataOutputStream(outputStream)) {
                for (int j : arr) {
                    out.writeInt(j);//записывает  поток  в файл если не использовать то выведет не массив int
                }
            }
        }

        public static int[] readInPutStreamArr(InputStream inputStream, int n) throws IOException {
            if (inputStream == null) {
                throw new IllegalArgumentException("inputStream==null");
            }
            if (n < 0) {
                throw new IllegalArgumentException("n<0");
            }
            int[] arr = new int[n];

            try (DataInputStream in = new DataInputStream(inputStream)) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = in.readInt();
                }
            }
            return arr;
        }

        public static void writerArrChar(Writer writer, int[] arr) throws IllegalArgumentException {
            if (writer == null || arr == null) {
                throw new IllegalArgumentException("writer==null || arr==null");
            }
            try (PrintWriter out = new PrintWriter(writer)) {
                for (int j : arr) {
                    out.print(j);
                    out.print(' ');
                }
            }
        }

        public static int[] readerArrChar(Reader reader, int n) throws IOException {
            if (reader == null) {
                throw new IllegalArgumentException("reader==null");
            }
            if (n < 0) {
                throw new IllegalArgumentException("n<0");
            }
            int[] arr = new int[n];


            try (BufferedReader in = new BufferedReader(reader)) {
                String[] strings = in.readLine().split(" ");

                if (strings.length < arr.length) {
                    throw new IOException("not enough ints to read");
                }

                for (int i = 0; i < arr.length; ++i) {
                    arr[i] = Integer.parseInt(strings[i]);
                }
                return arr;
            }

        }
        public static int[] readIntArrayFromFile(RandomAccessFile file, long pos)
                throws IOException {
            if (file == null || pos < 0) {
                throw new IllegalArgumentException("file == null || pos < 0");
            }

            file.seek(pos);//перемещение

            int[] array = new int[(int) ((file.length() - pos) / Integer.BYTES)];

            for (int i = 0; i < array.length; ++i) {
                array[i] = file.readInt();
            }
            return array;
        }

        public static List<String> ListWithTheExtensionInTheDirectory(String path, String extension)
        {
    File directory = new File(path);
    String[] files = directory.list();
    List<String> filesList = new ArrayList<>();
            if(files == null || extension == null) throw new IllegalArgumentException("file == null || exception == null ");
            for(String file : files){
                if(file.endsWith(extension)){
                    filesList.add(file);
                }
            }
            return filesList;
        }
}
//        {
//            if(file == null || extension == null) throw new IllegalArgumentException("file == null || exception == null ");
////            String regex;//шаблон для поиска строки в тексте
////            if (extension.length() == 0) {
////                regex = "^([.]?)([^.]*)$";
////            }
////            else {
////                regex = "^([.]?)([^.]*)[.]" + extension + "$";//$ конец строки
////            }
////            Pattern pattern = Pattern.compile(regex);
//           // Matcher matcher = pattern.matcher("");//поиск в тексте "" по regex
//
//            File[] fileArray = file.listFiles();
//
//            if (fileArray == null) {
//                throw new IllegalArgumentException("file is not a directory");
//            }
//
//            List<File> files = new ArrayList<>();
//
//            for (int i = 0; i < fileArray.length; ++i) {
//                if (fileArray[i].isFile()) {
//                    if(  file.getName().endsWith(extension)){
//                  //  matcher.reset(fileArray[i].getName());//сбрасывается  и задает новый
//
//                    //if (matcher.matches()) {
//                       files.add(fileArray[i]);
//                    }
//                }
//            }
//
//            return files;
//        }
//        }



