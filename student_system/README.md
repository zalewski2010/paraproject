## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.



# Student Management System (SMS)
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

Użytkownik wprowadza dane studenta: ID, imię,  nazwisko wiek i ocenę.
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
git clone <https://github.com/zalewski2010/paraproject/tree/main/student_system/src>


Otwórz projekt w IDE lub skompiluj go w terminalu:

javac -d bin -sourcepath src src/application/Main.java

Uruchom aplikację
W IDE:

Uruchom klasę Main.java.
Z terminala:
java -cp bin application.Main

# LUB w VSCODE

w projekcie utwórz folder libs
i ściagnij z internetu plik sqlite-jdbc-3.36.0.3.jar i wklej go do folderu libs

Konfiguracja bazy danych
W aplikacji wykorzystywana jest baza SQLite. Domyślna konfiguracja tworzy bazę danych students.db w katalogu głównym projektu w folderze database.
Tabela students zostanie automatycznie utworzona przy pierwszym uruchomieniu programu.


Następnie projekt należy kompilować :
javac -cp "src/libs/sqlite-jdbc-3.36.0.3.jar" -d bin src/**/*.java

uruchamiać :
java -cp "bin;src/libs/sqlite-jdbc-3.36.0.3.jar" application.Main



Struktura tabeli students:
sql
Skopiuj kod
CREATE TABLE students (
    name TEXT,
    eftername TEXT,
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



