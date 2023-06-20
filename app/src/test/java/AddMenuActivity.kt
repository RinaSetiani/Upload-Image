import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.DrawableContainer
import android.widget.ImageView

class AddMenuActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
    }
    super.onCreate(savedInstancestate)
    setContentView(R.layout.activity_add_nenu)

    getSupportActionBar()?.hide()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_makanan, container, attachToRoot: false)
        val rvmakanan: RecyclerView = view.findViewbyId(R.id.recycleMakanan)
        rvmakanan.layoutManager = LinierLayoutManager(activity)
        rvmakanan.adopter = MakananAdapter()

        val buttonAdd : Button = view.findViewbyId(R.id.buttonAddMenu)
        buttonAdd.setOnClickListener{ it View!
        requireActivity().run{ this FragmentAcrivity
        startActivity(Intent(pckageContext: this, AddMenuActivity::class,java))
        finish()
        }
        }

        return view
    }

    class AddMenuActivity : AppCompactActivity(){
        lateint var image : ImageView
        companion object{
            val IMAGE_REQUEST_CODE = 100
        }

        image = findViewbyId(R.id.imageMenu)
        val textId : EditText = findViewbyId(R.id.menuId)
        val textName : EditText = findViewbyId(R.id.menuName)
        val textPrice : EditText = findViewbyId(R.id.menuPrice)
        val btnAddImage : Button = findViewbyId(R.id.buttonAddImage)
        val btnSaveMenu : Button = findViewbyId(R.id.buttonSaveMenu)

        btnAddImage.setOnClickListener{ it:View!
        pickImageGalery()
        }

        private fun pickImageGalery(){
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/"
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
            super.onActivityResult(requestCode, resultCode, data)
            id(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
                image.setImageURl(data?.data)
            }
        }

        btnSaveMenu.setOnClickListener{ it:View!
        val databaseHelper = DatabaseHelper(context: this)

            val id : Int = textId.text.toString().toInt()
            val name : String = textName.text.toString().trim()
            val price : Int = textPrice.text.toString().toInt()
            val bitmapDrawable : BitmapDrawable = image.drawable as BitmapDrawable
            bal bitmap : Bitmap = bitmapDrawable.bitmap

                    val menuModel= MenuModel(id,name,price,bitmap)
            databaseHelper.addMenu(menuModel)
        }
    }
}