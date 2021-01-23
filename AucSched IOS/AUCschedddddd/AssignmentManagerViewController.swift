//
//  AssignmentManagerViewController.swift
//  AUCschedddddd
//
//  Created by Nourhan Mokbel on 1/22/21.
//

import UIKit

class AssignmentManagerViewController: UIViewController {
    @IBOutlet weak var assignmentTextField:UITextField!
    let course = ["CS106", "CS110", "PHY1", "CALC I", "CALC II", "Intro to engineering", "Drawing", "RHET 1010", "Core", "RHET1020","Chemistry" ]
    var  assignmentPickerView = UIPickerView()
    override func viewDidLoad() {
        super.viewDidLoad()
        assignmentTextField.inputView = assignmentPickerView
    assignmentTextField.placeholder = "select"
       assignmentTextField.textAlignment = .center
      assignmentPickerView.delegate = self
      assignmentPickerView.tag=1
        // Do any additional setup after loading the view.
    }
}
extension AssignmentManagerViewController: UIPickerViewDataSource,UIPickerViewDelegate
{
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        switch pickerView.tag{
        case 1:
            return course.count
        default:
            return 1
        }
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
    switch pickerView.tag{
        case 1:
            return course[row]
    default:
        return "Data not found."
    }
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        switch pickerView.tag{
            case 1:
               assignmentTextField.text = course[row]
               assignmentTextField.resignFirstResponder()
        default:
            return
        }}
}
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */


