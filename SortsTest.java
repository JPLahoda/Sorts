import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SortsTest extends Sorts {

        public static void main(String[] args) {

            try {
                File comparisonsFile = new File("comparisons.csv");
                comparisonsFile.createNewFile();
                File exchangesFile = new File("exchanges.csv");
                exchangesFile.createNewFile();
                File timeFile = new File("time.csv");
                timeFile.createNewFile();
                FileWriter timeFileWriter = new FileWriter("time.csv", true);
                timeFileWriter.append("Input, InsertionSort, QuickSort, ShellSort" + System.getProperty("line.separator"));
                timeFileWriter.close();
                FileWriter comparisonsFileWriter = new FileWriter("comparisons.csv", true);
                comparisonsFileWriter.append("Input, InsertionSort, QuickSort, ShellSort" + System.getProperty("line.separator"));
                comparisonsFileWriter.close();
                FileWriter exchangesFileWriter = new FileWriter("exchanges.csv", true);
                exchangesFileWriter.append("Input, InsertionSort, QuickSort, ShellSort" + System.getProperty("line.separator"));
                exchangesFileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 10; i <= 10300; i *= 2) {
                int[] arr1, arr2, arr3;
                arr1 = createIntArray(i);
                arr2 = arr1.clone();
                arr3 = arr2.clone();
                long startTime = System.nanoTime();
                int[] insertionSortResults = insertionSort(arr1);
                long insertTime = System.nanoTime() - startTime;
                startTime = System.nanoTime();
                int[] quickSortResults = quickSort(arr2, 0, arr2.length - 1);
                long quickTime = System.nanoTime() - startTime;
                startTime = System.nanoTime();
                int[] shellSortResults = shellSort(arr3);
                long shellTime = System.nanoTime() - startTime;

                try {
                    FileWriter timeFileWriter = new FileWriter("time.csv", true);
                    timeFileWriter.append(i + ", " + insertTime + ", " + quickTime + ", " + shellTime + System.getProperty("line.separator"));
                    timeFileWriter.close();
                    FileWriter comparisonsFileWriter = new FileWriter("comparisons.csv", true);
                    comparisonsFileWriter.append(i + ", " + insertionSortResults[0] + ", " + quickSortResults[0] + ", " + shellSortResults[0] + System.getProperty("line.separator"));
                    comparisonsFileWriter.close();
                    FileWriter exchangesFileWriter = new FileWriter("exchanges.csv", true);
                    exchangesFileWriter.append(i + ", " + insertionSortResults[1] + ", " + quickSortResults[1] + ", " + shellSortResults[1] + System.getProperty("line.separator"));
                    exchangesFileWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
}

