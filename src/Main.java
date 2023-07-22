import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void createDir(String dirToCreate, StringBuilder builder) {
        File src = new File(dirToCreate);
        if (src.mkdir()) {
            builder.append("Создали папку ").append(dirToCreate).append("\n");
        } else {
            builder.append("Папку ").append(dirToCreate).append(" создать не удалось \n");
        }
    }

    public static void createFile(String fileToCreate, StringBuilder builder) {
        File mainJava = new File(fileToCreate);
        try {
            if (mainJava.createNewFile()) {
                builder.append("Создали файл ").append(fileToCreate).append("\n");
            } else {
                builder.append("Файл ").append(fileToCreate).append(" создать не удалось \n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        createDir("D:\\Games\\src", builder);
        createDir("D:\\Games\\res", builder);
        createDir("D:\\Games\\savegames", builder);
        createDir("D:\\Games\\temp", builder);
        createDir("D:\\Games\\src\\main", builder);
        createDir("D:\\Games\\src\\test", builder);
        createDir("D:\\Games\\res\\drawables", builder);
        createDir("D:\\Games\\res\\vectors", builder);
        createDir("D:\\Games\\res\\icons", builder);

        createFile("D:\\Games\\src\\main\\main.java", builder);
        createFile("D:\\Games\\src\\main\\utils.java", builder);
        createFile("D:\\Games\\temp\\temp.txt", builder);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Games\\temp\\temp.txt"));
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}