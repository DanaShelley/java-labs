package edu.hav.labs.service.staff.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Staff;
import edu.hav.labs.repository.bookLog.BookLogRepository;
import edu.hav.labs.repository.staff.StaffRepository;
import edu.hav.labs.service.staff.interfaces.IStaffService;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class StaffServiceImpl implements IStaffService {

    final
    StaffRepository repository;

    final BookLogRepository bookLogRepository;

    public StaffServiceImpl(StaffRepository repository,
                            BookLogRepository bookLogRepository) {
        this.repository = repository;
        this.bookLogRepository = bookLogRepository;
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

    @Override
    public Document countServedMembershipsByStaffId(String id) {
        return new Document().append("staff", repository.findById(id))
                             .append("count", bookLogRepository.findAllByStaff_Id(id).size());
    }

    public Map<Staff, Integer> countServedMemberships() {
        Map<Staff, Integer> sorted = new LinkedHashMap<>();
        Map<Staff, Integer> map = new HashMap<>();
        bookLogRepository.findAll().forEach(bookLog -> map
                .put((repository.findById(bookLog.getStaff().getId()).orElse(null)),
                        bookLogRepository.findAllByStaff_Id(bookLog.getStaff().getId()).size()));
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
           .forEach(e ->sorted.put(e.getKey(),e.getValue()));

        return sorted;
    }
}
