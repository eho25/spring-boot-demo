package com.sboot.batch.steps;

import com.sboot.data.entities.Person;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 *
 */

@Configuration
public class Step1Configuration {

    @Bean
    public FlatFileItemReader<Person> fileReader(@Value("${input}")Resource in) throws Exception {
        return new FlatFileItemReaderBuilder<Person>()
                .name("file-reader")
                .resource(in)
                .targetType(Person.class)
                .delimited().delimiter(",").names(new String[]{"firstName","age","email"})
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person> jdbcWriter (DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource)
                .sql("insert into PEOPLE(AGE, FIRST_NAME, EMAIL) values (:age, :firstName, :email)")
                .beanMapped()
                .build();
    }
}
