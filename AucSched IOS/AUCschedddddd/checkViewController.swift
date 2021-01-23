//
//  checkViewController.swift
//  AUCschedddddd
//
//  Created by Nourhan Mokbel on 1/23/21.
//

import UIKit

class checkViewController: UITableViewController {

        let courses = ["CS106", "CS110", "PHY1", "CALC I", "CALC II", "Intro to engineering", "Drawing", "RHET 1010", "Core", "RHET1020","Chemistry" ]
        override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
            return courses.count
        }
        override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
            cell.textLabel?.text = courses[indexPath.row]
            return cell
        }
        override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
            tableView.cellForRow(at: indexPath)?.accessoryType = UITableViewCell.AccessoryType.checkmark
        }
        override func viewDidLoad() {
            super.viewDidLoad()

            // Do any additional setup after loading the view.
        }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
        

        /*
        // MARK: - Navigation

        // In a storyboard-based application, you will often want to do a little preparation before navigation
        override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
            // Get the new view controller using segue.destination.
            // Pass the selected object to the new view controller.
        }
        */

    }
