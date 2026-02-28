package ru.zyryanova.ProductService.service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zyryanova.ProductService.entity.admin.Admin;
import ru.zyryanova.ProductService.repo.AdminRepo;

@Service
public class RegistrationService {
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(AdminRepo adminRepo, PasswordEncoder passwordEncoder) {
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepo.save(admin);
    }
}
