
package com.jalinet.grupo11.service;

import com.jalinet.grupo11.dao.MotorbikeRepository;
import com.jalinet.grupo11.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MotorbikeService {
    @Autowired
    MotorbikeRepository motorbikeRepository;//-------------private al inicio
    
  public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeRepository.getAll();};
  
  public Optional<Motorbike> getMotorbike(int id) {return motorbikeRepository.getMotorbike(id);};
  
  public Motorbike save(Motorbike motorbike) {
        if (motorbike.getId() == null) {
            return motorbikeRepository.save(motorbike);
        } else {
            Optional<Motorbike> co = motorbikeRepository.getMotorbike(motorbike.getId());
            if (co.isEmpty()) {
                return motorbikeRepository.save(motorbike);
            } else {
                return motorbike;
            }
        }

    }
}
