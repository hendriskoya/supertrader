package br.com.supertrader.callstrategy.service;

import br.com.supertrader.callstrategy.model.CallStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class CallStrategyService {

    private final CallStrategyRepository callStrategyRepository;

    public CallStrategyService(CallStrategyRepository callStrategyRepository) {
        this.callStrategyRepository = callStrategyRepository;
    }

    public Optional<CallStrategy> findById(Integer id) {
        return callStrategyRepository.findById(id);
    }

    public static void main(String[] args) {
        List<Long> contactAttemptIds = new ArrayList();
        LongStream.rangeClosed(1, 102).forEach(num -> contactAttemptIds.add(num));

        System.out.println(contactAttemptIds.size());

        System.out.println();

        int size = 10;

        int max = Double.valueOf(Math.ceil(Double.valueOf(contactAttemptIds.size()) / Double.valueOf(size))).intValue();
        System.out.println(max);

        for (int i = 0; i < max; i++) {
            int start = (i * size);
            int end = (start + size);
            end = end > contactAttemptIds.size() ? contactAttemptIds.size(): end;

            System.out.println(start + " - " + end);

            System.out.println(contactAttemptIds.subList(start, end));
        }

    }
}
