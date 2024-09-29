package com.telusko.config;

import com.telusko.entity.Customer;
import com.telusko.repo.ICustomerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringBatchConfig {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private ICustomerRepository repo;


    @Autowired
    private PlatformTransactionManager transactionManager;

    //item reader
    @Bean
    public FlatFileItemReader<Customer> customerReader() {
        FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();

        itemReader.setResource(new FileSystemResource("src/main/resources/customer_data.csv"));
        itemReader.setName("csv-reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    //line mapper
    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");// this means all the records in csv file are comma separated data
        lineTokenizer.setStrict(false);// if some records are null in the csv file, ignore them don't create error
        lineTokenizer.setNames("customerId", "firstName", "lastName", "email", "phoneNumber", "address", "city", "state", "zipCode", "country");

        BeanWrapperFieldSetMapper<Customer> fieldMapper = new BeanWrapperFieldSetMapper<>();
        fieldMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldMapper);

//        lineMapper.setFieldSetMapper(fieldSet -> {
//            Customer customer = new Customer();
//            customer.setCustomerId(Integer.parseInt(fieldSet.readString(0)));
//            customer.setFirstName(fieldSet.readString(1));
//            customer.setLastName(fieldSet.readString(2));
//            customer.setEmail(fieldSet.readString(3));
//            customer.setPhoneNumber(fieldSet.readString(4));
//            customer.setAddress(fieldSet.readString(5));
//            customer.setCity(fieldSet.readString(6));
//            customer.setState(fieldSet.readString(7));
//            customer.setZipCode(fieldSet.readString(8));
//            customer.setCountry(fieldSet.readString(9));
//            return customer;
//        });
        return lineMapper;
    }

    // itemProcessor
    @Bean
    public CustomerProcessor processCxData() {
        return new CustomerProcessor();
    }

    //itemWriter
    @Bean
    public RepositoryItemWriter<Customer> itemWriterCx() {
        RepositoryItemWriter<Customer> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(repo);
        itemWriter.setMethodName("save");
        return itemWriter;
    }

    // step
    @Bean
    public Step step() {
        return new StepBuilder("step-1", jobRepo)
                .<Customer, Customer>chunk(10, transactionManager)
                .reader(customerReader())
                .processor(processCxData())
                .writer(itemWriterCx())
                .build();
    }

    // job
    @Bean
    public Job job() {
        return new JobBuilder("customer-import", jobRepo)
                .start(step())
                .build();
    }

}
