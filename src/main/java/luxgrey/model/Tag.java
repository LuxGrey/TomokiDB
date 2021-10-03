package luxgrey.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "tags")
public class Tag implements Externalizable {

  private int id;
  private StringProperty name;
  private String _name;
  private StringProperty note;
  private String _note;
  private Collection<IdentityTag> identities = new HashSet<>();

  public Tag() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    if (name == null) {
      return _name;
    } else {
      return name.get();
    }
  }

  public void setName(String name) {
    if (this.name == null) {
      _name = name;
    } else {
      this.name.set(name);
    }
  }

  public StringProperty nameProperty() {
    if (name == null) {
      name = new SimpleStringProperty(this, "name", _name);
    }
    return name;
  }

  @OneToMany(mappedBy = "tag")
  public Collection<IdentityTag> getIdentities() {
    return identities;
  }

  public void setIdentities(Collection<IdentityTag> identities) {
    this.identities = identities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tag tag = (Tag) o;
    return id == tag.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeInt(getId());
    out.writeObject(getName());
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    setId(in.readInt());
    setName((String) in.readObject());
  }
}
