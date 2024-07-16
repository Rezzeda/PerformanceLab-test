package main.java;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("нужны 3 файла values.json, tests.json и report.json");
            System.exit(1);
        }

        String valuesFilePath = args[0];
        String testsFilePath = args[1];
        String reportFilePath = args[2];

        TestReportGenerator generator = new TestReportGenerator();
        try {
            generator.generateReport(valuesFilePath, testsFilePath, reportFilePath);
            System.out.println("Отчет успешно сформирован");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}