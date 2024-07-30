
export default function LinkGroup({items}){
    return (

        <ul className="text-blue-gray-50 mb-10 w-32  xl:w-72 lg:w-52">
            {
                items.map(
                    (item) =>  (
                        <li key={item.title}
                            className="w-full first:rounded-t-xl border-b-2 p-2 xl:h-12 lg:h-20 bg-blue-gray-300/30 h-24 border-neutral-100 py-4 content-end  text-sm dark:border-white/10">
                            {item.title}
                        </li>
                    )
                )
            }

        </ul>
    )
}