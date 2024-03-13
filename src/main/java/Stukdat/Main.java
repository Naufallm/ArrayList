package Stukdat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private int phoneNumber;

    public Contact(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}

class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            for (Contact contact : contacts) {
                System.out.println("Nama: " + contact.getName() + ", Nomor Telepon: " + contact.getPhoneNumber());
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan:");
                System.out.println("Nama: " + contact.getName() + ", Nomor Telepon: " + contact.getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        System.out.println("Selamat datang di Manajemen Kontak!");

        int choice;
        do {
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    int phoneNumber = scanner.nextInt();
                    Contact newContact = new Contact(name, phoneNumber);
                    contactManager.addContact(newContact);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama yang akan dicari: ");
                    String searchName = scanner.nextLine();
                    contactManager.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
