package aDemo;

import java.io.*;
import java.util.*;

public class WordSorter {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            File inputFile; // 初始文件路径
            List<String> lines; // 初始文件内容

            // 输入文件路径
            System.out.println("请输入文件路径：");
            String filePath = scanner.nextLine();
            inputFile = new File(filePath);
            if (inputFile.exists()) {
                System.out.println("文件处理开始！");
            } else {
                return;
            }
            // 读取文件内容
            lines = readFile(inputFile);

            // 依次执行功能并生成文件
            lines = preprocess(lines);
            writeFile(lines, getOutputFileName(inputFile, 1));

            lines = sortColumns(lines);
            writeFile(lines, getOutputFileName(inputFile, 2));

            lines = sortLines(lines);
            writeFile(lines, getOutputFileName(inputFile, 3));

            lines = singleWordPerLine(lines);
            writeFile(lines, getOutputFileName(inputFile, 4));

            System.out.println("文件处理结束！");
        } catch (IOException e) {
            System.out.println("错误: " + e.getMessage());
        }
    }

    private static List<String> readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    private static List<String> preprocess(List<String> lines) {
        List<String> processedLines = new ArrayList<>();
        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty()) {
                processedLines.add(line.replaceAll("\\s+", " "));
            }
        }
        return processedLines;
    }

    private static List<String> sortColumns(List<String> lines) {
        List<String> sortedLines = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split("\\s+");
            Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
            sortedLines.add(String.join(" ", words));
        }
        return sortedLines;
    }

    private static List<String> sortLines(List<String> lines) {
        List<String> sortedLines = new ArrayList<>(lines);
        sortedLines.sort((s1, s2) -> {
            String[] words1 = s1.split("\\s+");
            String[] words2 = s2.split("\\s+");
            return words1[0].compareToIgnoreCase(words2[0]);
        });
        return sortedLines;
    }

    private static List<String> singleWordPerLine(List<String> lines) {
        List<String> singleWordLines = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split("\\s+");
            Collections.addAll(singleWordLines, words);
        }
        return singleWordLines;
    }

    private static String getOutputFileName(File inputFile, int choice) {
        String outputDir = inputFile.getParent(); // 输出文件目录与输入文件相同
        String outputFileName = inputFile.getName().replace(".txt", "");
        switch (choice) {
            case 1:
                outputFileName += "_预处理.txt";
                break;
            case 2:
                outputFileName += "_列排列.txt";
                break;
            case 3:
                outputFileName += "_行排列.txt";
                break;
            case 4:
                outputFileName += "_词独行.txt";
                break;
        }
        return outputDir + File.separator + outputFileName;
    }

    private static void writeFile(List<String> lines, String outputFileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
