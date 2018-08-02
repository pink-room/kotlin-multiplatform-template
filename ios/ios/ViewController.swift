import UIKit
import Common

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let recipe = CommonGetRecipe().run()
        recipeTitle.text = recipe.title
    }
    
    @IBOutlet weak var recipeTitle: UILabel!
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}

