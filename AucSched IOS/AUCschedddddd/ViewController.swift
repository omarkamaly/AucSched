//
//  ViewController.swift
//  AUCschedddddd
//
//  Created by Nourhan Mokbel on 1/22/21.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var buildingTextField:UITextField!
    @IBOutlet weak var locationTextField:UITextField!
    let building = ["Buildings","Departments","Advising"]
    let location = ["Administration Building","AUC Center for the Arts","AUC Park and Square","Abdul Latif Jameel Hall","Bartlett Plaza","Campus Centre","Hatem and Janet Mostafa Core Academic Center","University Garden","AUC Library","Research Centers Building","Prince Alwaleed Bin Talal Bin Abdulaziz Alsaud Hall","School of Sciences and Engineering","AUC Sports Center","University Residences","Students' Court","The Watson House","Computer Engineering","Business","History","Undeclared","Declared"]
    var buildingPickerView = UIPickerView()
    var locationPickerView = UIPickerView()
        override func viewDidLoad() {
            super.viewDidLoad()
            buildingTextField.inputView = buildingPickerView
            locationTextField.inputView = locationPickerView
            buildingTextField.placeholder = "select"
            locationTextField.placeholder = "select"
            
            buildingTextField.textAlignment = .center
            locationTextField.textAlignment = .center
            buildingPickerView.delegate = self
            buildingPickerView.dataSource=self
            locationPickerView.delegate = self
            locationPickerView.dataSource=self
            
            buildingPickerView.tag=1
            locationPickerView.tag=2
    }
    
}
extension ViewController: UIPickerViewDataSource,UIPickerViewDelegate
{
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        switch pickerView.tag{
        case 1:
            return building.count
        case 2:
            return location.count
        default:
        return 1        }
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
    switch pickerView.tag{
        case 1:
            return building[row]
        case 2:
            return location[row]
    default:
        return "Data not found."
        
    }
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        switch pickerView.tag{
            case 1:
                buildingTextField.text = building[row]
                buildingTextField.resignFirstResponder()
            case 2:
                locationTextField.text = location[row]
                locationTextField.resignFirstResponder()
        default:
            return 
            
        }
        
    }
}

