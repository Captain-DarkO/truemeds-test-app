package com.truemeds.testanurag.service;

import com.truemeds.testanurag.model.InputString;
import com.truemeds.testanurag.model.ReduceResult;
import com.truemeds.testanurag.repository.InputDataRepository;
import com.truemeds.testanurag.repository.ResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@EnableJpaAuditing
final class BatchDataProcessService implements BatchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchDataProcessService.class);

    private final InputDataRepository inputDataRepository;
    private final ResultRepository resultRepository;
    private final DataCleanService defaultDataCleanService;


    BatchDataProcessService(InputDataRepository inputDataRepository,
                                   ResultRepository resultRepository,
                                   DataCleanService defaultDataCleanService) {
        this.inputDataRepository = inputDataRepository;
        this.resultRepository = resultRepository;
        this.defaultDataCleanService = defaultDataCleanService;
    }

    @Override
    public void doCleanup(){
        LOGGER.info("Starting cleanup service");
        final Instant startInstant = Instant.now();

        for(InputString inputString : inputDataRepository.findAll()){
            final ReduceResult result = defaultDataCleanService.reduceCharacters(inputString.getInputString());
            resultRepository.save(result);
        }

        LOGGER.info("Cleanup job took {} ms", Duration.between(startInstant, Instant.now()).toMillis());
    }
}
