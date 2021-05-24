package edu.hav.labs.service.staff.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Staff;
import edu.hav.labs.repository.staff.StaffRepository;
import edu.hav.labs.service.staff.interfaces.IStaffService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StaffServiceImpl implements IStaffService {

    final
    StaffRepository repository;

    public StaffServiceImpl(StaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Staff getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Staff create(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public Staff update(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public Staff delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Staff> getAll() {
        return repository.findAll();
    }
}
