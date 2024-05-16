import java.io.*;

public class Main {
    public static void main(String[] args) {
        String readFile = "text.txt";
        String writeFile = "textNew.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(readFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFile)))
        {
            String line; //считываемая строка
            int vowelCount = 0; //гласные
            int consonantCount = 0; //согласные

            while ((line = bufferedReader.readLine()) != null) {

                String replacedLine = line.toLowerCase().replaceAll("[аеёийоуыэюя]", "a")
                        .replaceAll("[бвгджзклмнпрстфхцчшщ]", "м");

                //количествo гласных и согласных букв (кроме Ь и Ъ, они не относятся к гласным или согласным)
                vowelCount += line.toLowerCase().replaceAll("[^аеёиоуыэюя]", "").length();
                consonantCount += line.toLowerCase().replaceAll("[^бвгджзйклмнпрстфхцчшщ]", "").length();

                bufferedWriter.write(replacedLine);
                bufferedWriter.newLine();
            }

            System.out.println("В файле успешно произведена замена гласных букв на 'а', согласных на 'м'. За исключение Ь и Ъ знаков.");
            System.out.println("Количество гласных букв в файле: " + vowelCount);
            System.out.println("Количество согласных букв в файле: " + consonantCount);

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи или чтении файла");
        }

    }

}