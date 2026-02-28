package ru.zyryanova.ProductService.service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.zyryanova.ProductService.entity.admin.AdminDetails;
import ru.zyryanova.ProductService.repo.AdminRepo;

@Service
public class AdminDetailsService implements UserDetailsService {
    private final AdminRepo adminRepo;

    @Autowired
    public AdminDetailsService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AdminDetails(adminRepo.findByUsername(username));
    }

}
