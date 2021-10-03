package luxgrey.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "aliases")
public class Alias implements Externalizable {
  private int id;
  private StringProperty name;
  private String _name;
  private Identity identity;

  public Alias() {}

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

  @ManyToOne
  public Identity getIdentity() {
    return identity;
  }

  public void setIdentity(Identity identity) {
    this.identity = identity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Alias alias = (Alias) o;
    return id == alias.id;
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
