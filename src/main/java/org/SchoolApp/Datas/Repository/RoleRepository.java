package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Recherche un rôle par son libellé (ex : "Admin", "Manager", etc.)
    Role findByLibelle(String libelle);
}

