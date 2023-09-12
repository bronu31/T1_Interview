package com.example.T1interview.service.ServiceImpl;

import com.example.T1interview.model.Counter;
import com.example.T1interview.service.CalculateService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public Set<String> calculate(String str) {
        if (str==null||str.length()==0) return Collections.singleton("");
        StringBuilder stringBuilder=new StringBuilder();
        HashMap<Character, Counter> hashMap=new HashMap<>();
        char holder;
        str=str.toLowerCase();
        for (int i=0;i<str.length();i++){
            holder=str.charAt(i);
            if (hashMap.containsKey(holder)){
                hashMap.put(holder,hashMap.get(holder).updateValue());
            }
            else {
                hashMap.put(holder,new Counter(holder));
            }
        }
        ArrayList<Counter> counts=new ArrayList<>(hashMap.values());
        Collections.sort(counts,Collections.reverseOrder());
        for (Counter counter: counts) stringBuilder.append(counter.toString());
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return Collections.singleton(stringBuilder.toString());
    }
}
