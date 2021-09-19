package luxgrey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "identities")
public class Identity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @OneToMany(mappedBy = "identity")
  private Collection<Weblink> weblinks = new HashSet<>();
  @OneToMany(mappedBy = "identity")
  private Collection<Tag> tags = new HashSet<>();
  @OneToMany(mappedBy = "identity")
  private Collection<Alias> aliases = new HashSet<>();

  public Identity() {}

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identity identity = (Identity) o;
    return id == identity.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public int getId() {
    return id;
  }
}
