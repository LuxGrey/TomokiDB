package luxgrey.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import luxgrey.App;

public class IdentityListCellController {
  @FXML
  private HBox hBox;
  @FXML
  private Label primaryAlias;

  public IdentityListCellController() {
    FXMLLoader fxmlLoader = App.createFXMLLoader("IdentityListCell");
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void setPrimaryAlias(String primaryAlias) {
    this.primaryAlias.setText(primaryAlias);
  }

  public HBox getRoot() {
    return hBox;
  }
}
