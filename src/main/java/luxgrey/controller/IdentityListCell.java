package luxgrey.controller;

import javafx.scene.control.ListCell;
import luxgrey.model.Identity;

public class IdentityListCell extends ListCell<Identity> {
  @Override
  public void updateItem(Identity identity, boolean empty) {
    super.updateItem(identity, empty);
    if (identity != null) {
      //IdentityListCellController cell = new IdentityListCellController();
      //cell.setPrimaryAlias();
    }
  }
}
