package one;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static one.InputOutputService.*;

public class InputOutputServiceTest {
    private static File tests;
    private Assert Assertions;

    @Before
    public void createTestsDir() {
        tests = new File("test/oneTwo/");
        tests.mkdirs();
    }
//1
    @Test
    public void writeOutPutStreamArrTest() throws IOException {
        int[] expected = {500000000, 1, 29, -2, -1002};

        byte[] byteArrBuf;

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            writeOutPutStreamArr(out, expected);

            byteArrBuf = out.toByteArray();
        }

        int[] actual;

        try (ByteArrayInputStream in = new ByteArrayInputStream(byteArrBuf)) {
            actual = readInPutStreamArr(in, expected.length);
        }

        Assertions.assertArrayEquals(expected, actual);
    }
//2
    @Test
    public void testWriteReadIntArrayChar() throws IOException {
        int[] expected = {-12345678, -1, 42, 58, 30420};

        char[] charArrBuf;

        try (CharArrayWriter out = new CharArrayWriter()) {
            writerArrChar(out, expected);

            charArrBuf = out.toCharArray();
        }

        int[] actual;

        try (CharArrayReader in = new CharArrayReader(charArrBuf)) {
            actual = readerArrChar(in, expected.length);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    //3
    @Test
    public void testReadIntArrayFromFile() throws IOException {
        File file = new File(tests, "testReadIntArrayFromFile");
        file.createNewFile();

        int[] writeArray = {101, 31415, 2, 3, -231};
        int[] expected = {2, 3, -231};

        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            for (int i = 0; i < writeArray.length; ++i) {
                out.writeInt(writeArray[i]);
            }
        }

        int[] actual;

        try (var randomAccessFile = new RandomAccessFile(file, "r")) {
            actual = readIntArrayFromFile(randomAccessFile, 8);
        }

        Assertions.assertArrayEquals(expected, actual);
    }


}


