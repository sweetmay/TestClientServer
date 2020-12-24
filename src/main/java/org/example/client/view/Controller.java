package org.example.client.view;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.client.model.retrofit.ApiHolder;
import org.example.client.model.retrofit.repo.IRepo;
import org.example.client.model.retrofit.repo.Repo;
import org.example.client.model.retrofit.entity.Contract;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public javafx.scene.control.TableView<Contract> tableView;

    ApiHolder apiHolder = new ApiHolder("http://127.0.0.1:8189/");
    IRepo repo = new Repo(apiHolder);

    TableColumn<Contract, String> contractIdColumn = new TableColumn<>("Contract Id");
    TableColumn<Contract, Boolean> contractValidColumn = new TableColumn<>("Is contract valid");
    TableColumn<Contract, String> contractDateColumn = new TableColumn<>("Contract date");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contractIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        contractValidColumn.setCellValueFactory(new PropertyValueFactory<>("valid"));
        contractDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.getColumns().add(contractIdColumn);
        tableView.getColumns().add(contractDateColumn);
        tableView.getColumns().add(contractValidColumn);


        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Disposable disposable = repo.getContracts().subscribe(contracts -> {
            LocalDate now = LocalDate.now();
            for (Contract contract : contracts) {
                contract.checkIfValid(now);
            }
            ObservableList<Contract> list = FXCollections.observableList(contracts);
            tableView.setItems(list);
        }, error->{
            //
        });

        compositeDisposable.add(disposable);

    }


}
