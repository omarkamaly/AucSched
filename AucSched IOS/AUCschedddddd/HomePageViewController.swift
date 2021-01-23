//
//  HomePageViewController.swift
//  AUCschedddddd
//
//  Created by Nourhan Mokbel on 1/22/21.
//

import UIKit

class HomePageViewController: UIViewController {
    
    @IBAction func OnClickmap(_ sender: Any) {
        self.performSegue(withIdentifier: "Map", sender: (Any).self)
        
    }
    
//    @IBAction func OnClickadvising(_ sender: Any) {
//            performSegue(withIdentifier: "ToAdvising", sender: nil)
//    }
//    @IBAction func OnClickViewmap(_ sender: Any) {
//
//        performSegue(withIdentifier: "ToMap", sender: nil)
//
//    }
//
//
//        @IBAction func OnClickShowbus(_ sender: Any) {
//            performSegue(withIdentifier: "ToBus", sender: nil)
//        }
//    @IBAction func OnClickEditcatalog(_ sender: Any) {
//        performSegue(withIdentifier: "ToCatalog", sender: nil)
//    }
//    @IBAction func OnClickEditCalander(_ sender: Any) {
//        performSegue(withIdentifier: "ToCalendar", sender: nil)
//    }
//    @IBAction func OnClickEditAssignment_( sender: Any) {
//        performSegue(withIdentifier: "ToAssignment", sender: nil)
//    }
    override func viewDidLoad() {
        super.viewDidLoad()
        print("View has loadded!)")
        // Do any additional setup after loading the view.
//        self.hideKeyboardWhenDone()

    }

//    override func didReceiveMemoryWarning() {
//        super.didReceiveMemoryWarning()
//        // Dispose of any resources that can be recreated.
//    }
    
}
