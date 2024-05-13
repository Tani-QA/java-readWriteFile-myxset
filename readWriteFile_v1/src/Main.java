import java.io.*;

public class Main {
    public static void main(String[] args) {
        String readFile = "text.txt";
        String writeFile = "textNew.txt";

        try(FileReader fileReader = new FileReader(readFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(writeFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            String line; //считываемая строка
            int vowelCount = 0; //гласные
            int consonantCount = 0; //согласные

            while ((line = bufferedReader.readLine()) != null) {
                for (char symbol: line.toCharArray()) { //перебор посимвольно считываемой строки
                    if (Character.isLetter(symbol)) { //если символ - буква Unicode
                        if (isVowel(symbol)) { //если буква гласная - заменить и посчитать кол-во
                            bufferedWriter.write('a');
                            vowelCount++;
                        } else {
                            bufferedWriter.write('м');
                            consonantCount++;
                        }
                    } else {
                        bufferedWriter.write(symbol); //запись символа (не буква)
                    }
                }

                bufferedWriter.newLine();
            }

            System.out.println("Количество гласных букв в файле: " + vowelCount);
            System.out.println("Количество согласных букв в файле: " + consonantCount);

        } catch (IOException e) {
            System.out.println("Что-то пошло не так при записи или чтении файла");
        }

    }

    //перевод букв в нижний регистр и проверка - гласная ли буква
    private static boolean isVowel(char letter) {
        letter = Character.toLowerCase(letter);
        return letter == 'а' || letter == 'е' || letter == 'ё' || letter == 'и' || letter == 'о' || letter == 'у' || letter == 'ы' || letter == 'э' || letter == 'ю' || letter == 'я';
    }
}