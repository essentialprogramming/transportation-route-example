class City extends React.Component {

  state = {
    data: [],
  }

  componentDidMount() {
    const url = '/routes'

       fetch(url)
         .then(result => result.json())
         .then(result => {
           this.setState({
             data: result,
           })
         })
  }

  render() {
    const { data } = this.state
console.log(data)
    const result =  data.map(item => (
                                 <li  key={item.id}>
                                   <div>{item.name}</div>
                                 </li>
                    ))

    return  (
        <div>
            <ul>
                {result}
            </ul>
        </div>
    )
  }

}

ReactDOM.render(<City />, document.getElementById('root'))