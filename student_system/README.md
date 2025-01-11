## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

Student Management System (SMS)
Opis projektu
Student Management System (SMS) to aplikacja desktopowa napisana w języku Java z wykorzystaniem Swing, JDBC oraz bazy danych SQLite. System umożliwia zarządzanie danymi studentów, takie jak:

Dodawanie nowych studentów.
Usuwanie studentów na podstawie ich ID.
Aktualizowanie danych istniejących studentów.
Wyświetlanie listy wszystkich studentów.
Obliczanie średniej ocen wszystkich studentów.
Aplikacja posiada graficzny interfejs użytkownika (GUI), dzięki któremu obsługa programu jest intuicyjna.

Funkcjonalności
Dodawanie studenta:

Użytkownik wprowadza dane studenta: ID, imię, wiek i ocenę.
Walidacja danych (np. wiek musi być liczbą dodatnią, a ocena w zakresie 0-100).
Dane są zapisywane w bazie SQLite.
Usuwanie studenta:

Użytkownik podaje unikalne ID studenta.
Student o podanym ID zostaje usunięty z bazy danych.
Aktualizowanie danych studenta:

Użytkownik wybiera istniejącego studenta na podstawie ID i wprowadza zaktualizowane dane.
Wyświetlanie wszystkich studentów:

Wszystkie rekordy z bazy danych są wyświetlane w panelu tekstowym GUI.
Obliczanie średniej ocen:

System oblicza i wyświetla średnią ocen wszystkich studentów w bazie danych.
Wymagania systemowe
Java Development Kit (JDK) 8 lub nowszy.
SQLite (wbudowana baza danych SQLite3).
IDE (np. IntelliJ IDEA, Eclipse) lub możliwość uruchamiania programów w Javie z terminala.
Instrukcje instalacji i uruchamiania
1. Pobierz i skompiluj kod
Sklonuj repozytorium lub pobierz projekt:
bash
Skopiuj kod
git clone <URL_REPOZYTORIUM>
cd <FOLDER_PROJEKTU>
Otwórz projekt w IDE lub skompiluj go w terminalu:
bash
Skopiuj kod
javac -d bin -sourcepath src src/application/Main.java
2. Uruchom aplikację
W IDE:

Uruchom klasę Main.java.
Z terminala:

bash
Skopiuj kod
java -cp bin application.Main
Konfiguracja bazy danych
W aplikacji wykorzystywana jest baza SQLite. Domyślna konfiguracja tworzy bazę danych students.db w katalogu głównym projektu.
Tabela students zostanie automatycznie utworzona przy pierwszym uruchomieniu programu.

Jeśli  nie zostanie utworzona to ściągnij do folderu libs
plik sqlite-jdbc-3.36.0.3.jar

Następnie projekt można kompilować :
javac -cp "src/libs/sqlite-jdbc-3.36.0.3.jar" -d bin src/**/*.java

uruchamiać :
java -cp "bin;src/libs/sqlite-jdbc-3.36.0.3.jar" application.Main



Struktura tabeli students:
sql
Skopiuj kod
CREATE TABLE students (
    name TEXT,
    age INTEGER,
    grade REAL,
    studentID TEXT PRIMARY KEY
);
Przykłady działania
Dodanie nowego studenta
W GUI wprowadź:
ID: ID123
Imię: Anna Kowalska
Wiek: 20
Ocena: 85.5
Kliknij przycisk "Add Student".
W obszarze tekstowym pojawi się komunikat: Student added successfully!.
Wyświetlenie wszystkich studentów
Kliknij przycisk "Display All Students".
W obszarze tekstowym zobaczysz listę studentów:
yaml
Skopiuj kod
Student ID: ID123, Name: Anna Kowalska, Age: 20, Grade: 85.5
Struktura projektu
model/ – Zawiera klasę Student, która reprezentuje dane studenta.
manager/ – Zawiera interfejs StudentManager oraz jego implementację StudentManagerImpl. Odpowiada za logikę biznesową i operacje na bazie danych.
gui/ – Zawiera GUI oparte na Swing (StudentManagementSystem).
application/ – Zawiera klasę Main.java, która uruchamia aplikację.
Obsługa wyjątków
Błędne dane wejściowe:
Wiek i ocena muszą być poprawnymi liczbami.
Ocena musi być w zakresie 0-100.
Nieznalezienie studenta:
Przy próbie usunięcia/aktualizacji studenta, który nie istnieje w bazie, pojawi się komunikat o błędzie.
Błędy bazy danych:
Aplikacja obsługuje wyjątki SQL, zapewniając, że aplikacja nie ulegnie awarii.
To Do
Dodanie bardziej zaawansowanego systemu walidacji danych.
Rozszerzenie interfejsu GUI o możliwość wyszukiwania studentów po ID.
Dodanie opcji eksportu listy studentów do pliku CSV.

