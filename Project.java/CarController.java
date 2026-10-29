import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarController {

    public void addCar(
            JTextField txtPlateNumber,
            JTextField txtBrandModel,
            JTextField txtDailyRate,
            JTextField txtMileage,
            JComboBox<String> cmbStatus,
            JTable tblCars) {

        String plate = txtPlateNumber.getText().trim();
        String brand = txtBrandModel.getText().trim();
        String rate = txtDailyRate.getText().trim();
        String mileage = txtMileage.getText().trim();
        String status = cmbStatus.getSelectedItem().toString();

        if (plate.isEmpty()
                || brand.isEmpty()
                || rate.isEmpty()
                || mileage.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please fill all fields!"
            );

            return;
        }

        DefaultTableModel model =
                (DefaultTableModel) tblCars.getModel();

        model.addRow(new Object[]{
            plate,
            brand,
            rate,
            mileage,
            status
        });
                                
        txtPlateNumber.setText("");
        txtBrandModel.setText("");
        txtDailyRate.setText("");
        txtMileage.setText("");
        cmbStatus.setSelectedIndex(0);

        JOptionPane.showMessageDialog(
                null,
                "Car Added Successfully!"
        );
    }

    public void deleteCar(JTable tblCars) {

        int selectedRow = tblCars.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please Select A Car First!"
            );

            return;
        }

        DefaultTableModel model =
                (DefaultTableModel) tblCars.getModel();

        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(
                null,
                "Car Deleted Successfully!"
        );
    }
}
