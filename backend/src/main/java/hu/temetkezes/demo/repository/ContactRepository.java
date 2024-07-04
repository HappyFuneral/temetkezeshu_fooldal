package hu.temetkezes.demo.repository;

import hu.temetkezes.demo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
