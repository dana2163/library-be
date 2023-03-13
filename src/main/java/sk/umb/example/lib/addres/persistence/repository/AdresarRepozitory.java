package sk.umb.example.lib.addres.persistence.repository;



  import org.springframework.data.repository.CrudRepository;
  import org.springframework.stereotype.Repository;
  import sk.umb.example.library.address.persistence.entity.AddressEntity;

  import java.util.List;

@Repository
public class AdresarRepozitory extends CrudRepository<AddressEntity, Long> {
  @Override
  List<AddressEntity> findAll();

}
