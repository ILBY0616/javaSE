package aDemo;

import java.io.*;

public class SQLScriptProcessor {

    public static void main(String[] args) {
        String inputFile = "D:\\IDEA\\WorkPlace\\financialManagementSystem-master\\cwgl.sql"; // 输入的SQL文件路径
        String outputFile = "D:\\IDEA\\WorkPlace\\financialManagementSystem-master\\cwgl1.0.sql"; // 输出的SQL文件路径，用于保存只包含建表语句的内容

        processSQLFile(inputFile, outputFile);
    }

    public static void processSQLFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            StringBuilder createStatement = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("CREATE TABLE")) {
                    createStatement.setLength(0); // 清空StringBuilder
                    createStatement.append(line); // 开始记录CREATE TABLE语句
                    while (!(line = reader.readLine()).endsWith(";")) {
                        createStatement.append("\n").append(line); // 继续读取直到找到分号结束
                    }
                    createStatement.append("\n").append(line); // 添加最后的分号
                    writer.write(createStatement.toString()); // 将CREATE TABLE语句写入输出文件
                    writer.newLine(); // 换行
                }
            }

            System.out.println("处理完成，建表语句已写入文件: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
