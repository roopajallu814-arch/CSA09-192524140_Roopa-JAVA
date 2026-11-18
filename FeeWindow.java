import java.awt.*;
import java.awt.event.*;

class FeeService {

    public String payFee(String regNo, String amountText) {

        if (regNo.isEmpty() || amountText.isEmpty()) {
            return "Please fill all fields";
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                return "Enter a valid amount";
            }

            // Payment processing can be connected to JDBC here.
            return "Payment successful";

        } catch (NumberFormatException e) {
            return "Invalid amount";
        }
    }
}

public class FeeWindow extends Frame {

    TextField regNo = new TextField(15);
    TextField amount = new TextField(15);

    Button pay = new Button("Pay");
    Button clear = new Button("Clear");
    Button receipt = new Button("Receipt");

    Label status = new Label("Enter payment details");

    FeeService service = new FeeService();

    public FeeWindow() {

        setTitle("Student Fee Payment");
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new Label("Register Number:"));
        add(regNo);

        add(new Label("Amount:"));
        add(amount);

        add(pay);
        add(clear);

        add(receipt);
        add(status);

        pay.addActionListener(e -> {
            String result = service.payFee(
                regNo.getText(),
                amount.getText()
            );

            status.setText(result);
        });

        clear.addActionListener(e -> {
            regNo.setText("");
            amount.setText("");
            status.setText("Fields cleared");
        });

        receipt.addActionListener(e -> {
            status.setText("Receipt feature selected");
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeWindow();
    }
}
