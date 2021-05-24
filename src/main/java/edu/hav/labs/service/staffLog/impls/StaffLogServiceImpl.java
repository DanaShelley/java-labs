package edu.hav.labs.service.staffLog.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffLogServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StaffLog;
import edu.hav.labs.repository.staffLog.StaffLogRepository;
import edu.hav.labs.service.staffLog.interfaces.IStaffLogService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StaffLogServiceImpl implements IStaffLogService {

    final
    StaffLogRepository repository;

    public StaffLogServiceImpl(StaffLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public StaffLog getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public StaffLog create(StaffLog staffLog) {
        return repository.save(staffLog);
    }

    @Override
    public StaffLog update(StaffLog staffLog) {
        return repository.save(staffLog);
    }

    @Override
    public StaffLog delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<StaffLog> getAll() {
        return repository.findAll();
    }
}
