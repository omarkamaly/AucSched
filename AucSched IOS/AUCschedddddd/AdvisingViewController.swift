//
//  AdvisingViewController.swift
//  AUCschedddddd
//
//  Created by Nourhan Mokbel on 1/22/21.
//

import UIKit

class AdvisingViewController: UIViewController {
        @IBOutlet weak var semesterTextField:UITextField!
        @IBOutlet weak var majorTextField:UITextField!
        @IBOutlet weak var intendingTextField:UITextField!
        @IBOutlet weak var planTextField:UITextField!
    
        let semester = ["one","two","three","four","five","six","seven","eight","nine","ten"]
        let major = ["Computer Engineering","Computer Science","Undeclared"]
        let intending = ["Computer Engineering","Computer Science"]
        let plan = ["2019","2016","2013"]
    
        var semesterPickerView = UIPickerView()
        var majorPickerView = UIPickerView()
        var intendingPickerView = UIPickerView()
        var planPickerView = UIPickerView()
    
    override func viewDidLoad() {
                super.viewDidLoad()
                semesterTextField.inputView =  semesterPickerView
                majorTextField.inputView = majorPickerView
                intendingTextField.inputView = intendingPickerView
                planTextField.inputView = planPickerView
                
                semesterTextField.placeholder = "Select Semester number"
                majorTextField.placeholder = "Select your Major"
                intendingTextField.placeholder = "Select you intending major if your are Undeclared "
                planTextField.placeholder = "Select your Plan"
                
                semesterTextField.textAlignment = .center
                majorTextField.textAlignment = .center
                intendingTextField.textAlignment = .center
                planTextField.textAlignment = .center
                
                semesterPickerView.delegate = self
                majorPickerView.dataSource=self
                intendingPickerView.delegate = self
                planPickerView.dataSource=self
                
                semesterPickerView.tag=1
                majorPickerView.tag=2
                intendingPickerView.tag=3
                planPickerView.tag=4
        }
        
    }
    extension AdvisingViewController: UIPickerViewDataSource,UIPickerViewDelegate
    {
        func numberOfComponents(in pickerView: UIPickerView) -> Int {
            return 1
        }
        func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
            switch pickerView.tag{
            case 1:
                return semester.count
            case 2:
                return major.count
            case 3:
                return intending.count
            case 4:
                return plan.count
            default:
            return 1
                
            }
        }
        func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        switch pickerView.tag{
            case 1:
                return semester[row]
            case 2:
                return major[row]
            case 3:
                return intending[row]
            case 4:
                return plan[row]
        default:
            return "Data not found."
            
        }
        }
        func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
            switch pickerView.tag{
                case 1:
                    semesterTextField.text = semester[row]
                   semesterTextField.resignFirstResponder()
                case 2:
                    majorTextField.text = major[row]
                    majorTextField.resignFirstResponder()
                case 3:
                   intendingTextField.text = intending[row]
                   intendingTextField.resignFirstResponder()
                case 4:
                    planTextField.text = plan[row]
                   planTextField.resignFirstResponder()
            default:
                return
                
            }
            
        }
    }
