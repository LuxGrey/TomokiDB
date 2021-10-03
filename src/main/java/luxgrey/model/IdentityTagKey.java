package luxgrey.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdentityTagKey implements Serializable {
  @Column(name = "identity_id")
  private int identityId;

  @Column(name = "tag_id")
  private int tagId;

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
