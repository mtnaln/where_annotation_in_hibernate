package com.metin.where.annotation;

import com.metin.where.annotation.entity.Book;
import com.metin.where.annotation.entity.Writer;
import com.metin.where.annotation.repository.BookRepository;
import com.metin.where.annotation.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WhereAnnotationDemoApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WriterRepository writerRepository;

    public static void main(String[] args) {
        SpringApplication.run(WhereAnnotationDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Writer franzKafka = new Writer("Franz", "Kafka", false, null);

        Book donusum = new Book("Dönüşüm", "12345", false, franzKafka);
        Book dava = new Book("Dava", "56789", true, franzKafka);
        Book sato = new Book("Şato", "12345", true, franzKafka);
        Book babayaMektup = new Book("Babaya Mektup", "111122", false, franzKafka);

        List<Book> kafkaBooks = Arrays.asList(donusum, dava, sato, babayaMektup);
        franzKafka.setBooks(kafkaBooks);

        writerRepository.save(franzKafka);

        Writer stephenKing = new Writer("Stephen", "King", true, null);

        Book o = new Book("O", "121212", false, stephenKing);
        Book goz = new Book("Göz", "444555", false, stephenKing);
        Book sadist = new Book("Şato", "666777", true, stephenKing);
        Book hayvanMezarligi = new Book("Hayvan Mezarlığı", "2222323", false, stephenKing);

        List<Book> kingBooks = Arrays.asList(o, goz, sadist, hayvanMezarligi);
        stephenKing.setBooks(kingBooks);

        writerRepository.save(stephenKing);

        writerRepository.findAll().forEach(writer -> System.out.println(writer));
    }
}
