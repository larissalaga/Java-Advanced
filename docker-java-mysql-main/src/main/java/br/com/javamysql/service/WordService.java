package br.com.javamysql.service;

import br.com.javamysql.entity.Word;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface WordService {
    Word createWord(Word word);

    Word getWordById(Long userId) throws ChangeSetPersister.NotFoundException;

    List<Word> getAllWords();

    Word updateWord(Word word);

    void deleteWord(Long wordId);
}
