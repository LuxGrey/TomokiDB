package luxgrey.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdentityTagKey implements Serializable {
  @Column(name = "identity_id")
  int identityId;

  @Column(name = "tag_id")
  int tagId;

  public int getIdentityId() {
    return identityId;
  }

  public void setIdentityId(int identityId) {
    this.identityId = identityId;
  }

  public int getTagId() {
    return tagId;
  }

  public void setTagId(int tagId) {
    this.tagId = tagId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityTagKey that = (IdentityTagKey) o;
    return identityId == that.identityId && tagId == that.tagId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(identityId, tagId);
  }
}
