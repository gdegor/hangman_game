# Игра «Виселица»

Классическая игра в слова, реализованная на языке Java, в консольном интерфейсе. Словарь загаданных слов находится в
resource/russian_nouns.txt.
___

Техническое задание проекта: https://zhukovsd.github.io/java-backend-learning-course/Projects/Hangman/
___

Для успешного запуска приложения:
- откройте терминал
- перейдите в папку `hangman_game`
- скомпилируйте программу:
    - `javac src/main/*.java -d classes`
    - `jar -cvfm hangman.jar resource/META-INF/MANIFEST.MF -C classes main -C resource russian_nouns.txt`
- запустите игру `java -jar hangman.jar`

![1](img/1.png)
![2](img/2.png)