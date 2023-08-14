package com.udemy.primeiroprojetosprinbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Bean
	public Job imprimeOlaJob(JobRepository jobRepository, Step step) {
		return new JobBuilder("job", jobRepository).start(step)
				// somente se o job não precisar ser inicializado
				// se inicializado ele não continua o processo anterior
				.incrementer(new RunIdIncrementer()).build();
	}

}
