import UIKit
import Common
import SDWebImage

class ViewController: UIViewController, CommonMemesContractView {
    
    private let presenter = CommonMemesPresenter(getMemes: CommonGetMemes(memeRepository: CommonMemeRepository()))
    
    @IBOutlet weak var memeView: UIImageView!
    @IBOutlet weak var titleView: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.start(view: self)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func nextView(_ sender: Any) {
        presenter.onNextClicked()
    }
    
    func showMemeImage(url: String) {
        memeView.sd_setImage(with: URL(string: url))
    }
    
    func showMemeTitle(title: String) {
        titleView.text = title
    }
}
