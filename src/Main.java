import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Stanislav Rakitov in 2022
 */
public class Main {
  public static void main(String[] args) {

    StringBuilder logFile = new StringBuilder();
    // В папке Games создайте несколько директорий: src, res, savegames, temp.
    createDirWithLogMessahe(logFile, "H:\\Games\\src");
    createDirWithLogMessahe(logFile, "H:\\Games\\res");
    createDirWithLogMessahe(logFile, "H:\\Games\\savegames");
    createDirWithLogMessahe(logFile, "H:\\Games\\temp");

    // В каталоге src создайте две директории: main, test.
    createDirWithLogMessahe(logFile, "H:\\Games\\src\\main");
    createDirWithLogMessahe(logFile, "H:\\Games\\src\\test");

    // В подкаталоге main создайте два файла: Main.java, Utils.java.
    createFile("H:\\Games\\src\\main\\Main.java", logFile);
    createFile("H:\\Games\\src\\main\\Utils.java", logFile);

    // В каталог res создайте три директории: drawables, vectors, icons.
    createDirWithLogMessahe(logFile, "H:\\Games\\res\\drawables");
    createDirWithLogMessahe(logFile, "H:\\Games\\res\\vectors");
    createDirWithLogMessahe(logFile, "H:\\Games\\res\\icons");

    // В директории temp создайте файл temp.txt.
    createFile("H:\\Games\\temp\\temp.txt", logFile);

    // Файл temp.txt должен содержать информацию о том, что все файлы были созданы успешно.
    try (BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter("H:\\Games\\temp\\temp.txt"))) {
      bufferedWriter.write(logFile.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void createDirWithLogMessahe(StringBuilder logFile, String dirName) {
    File srcDir = new File(dirName);
    logFile
        .append("Directory ")
        .append(dirName)
        .append(srcDir.mkdir() ? " is" : " is not")
        .append(" " + "created\n");
  }

  private static void createFile(String fileName, StringBuilder logFile) {
    File newFile = new File(fileName);
    try {
      logFile
              .append("File ")
              .append(fileName)
              .append(newFile.createNewFile() ? " is" : " is not")
              .append(" created\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
