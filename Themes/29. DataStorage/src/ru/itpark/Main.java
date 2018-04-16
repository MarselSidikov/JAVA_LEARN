package ru.itpark;

import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;
import ru.itpark.repository.UsersRepositoryFileWriterImpl;
import ru.itpark.util.IdGeneratorFileBasedImpl;
import ru.itpark.util.IdGeneratorInMemoryImpl;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UsersRepository usersRepository =
            new UsersRepositoryFileWriterImpl("users.txt", IdGeneratorFileBasedImpl.generator());
        User marsel = new User("Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        User marsel1 = new User("Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        User marsel2 = new User("Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        usersRepository.save(marsel);
        usersRepository.save(marsel1);
        usersRepository.save(marsel2);
    }
}
